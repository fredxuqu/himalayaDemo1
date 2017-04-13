package com.himalaya.interceptor;

import java.io.InputStream;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.helpers.XMLUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.DelegatingInputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.staxutils.StaxUtils;
import org.apache.log4j.Logger;

public class MessageInInterceptor extends AbstractPhaseInterceptor<Message> {

	private static final Logger logger = Logger.getLogger(MessageInInterceptor.class);

	public MessageInInterceptor() {
		super(Phase.RECEIVE);
	}

	public void handleMessage(Message message) {

		System.out.println("MessageInInteceptor.handleMessage() called ");

		try {

			System.out.println("getInMessage------------------" + message.getExchange().getInMessage());
			System.out.println("getInFaultMessage------------------" + message.getExchange().getInFaultMessage());

			if ("GET".equals(message.get(message.HTTP_REQUEST_METHOD))) {

				String requestString = (String) message.get(Message.QUERY_STRING);
				System.out.println("Get method : " + URLDecoder.decode(requestString, "UTF-8"));

			} else if ("POST".equals(message.get(message.HTTP_REQUEST_METHOD))) {

				InputStream is = message.getContent(InputStream.class);
				// Set<String> body = message.getContextualPropertyKeys();
				// System.out.println(body);
				Object soapVersion = message.getContextualProperty("org.apache.cxf.binding.soap.SoapVersion");
				System.out.println(soapVersion);

				Object encoding = message.getContextualProperty("org.apache.cxf.message.Message.ENCODING");
				System.out.println(encoding);

				String uri = (String) message.get(Message.REQUEST_URI);
				System.out.println(uri);

				// post method, queryString is null.
				String query = (String) message.get(Message.QUERY_STRING);
				System.out.println(query);

				String context = getContext(message);
				System.out.println("------- " + context);

				InputStream iStream = message.getContent(InputStream.class);
				// if (is != null) {
				// Integer limit = -1;
				// CachedOutputStream bos = new CachedOutputStream();
				// IOUtils.copyAtLeast(iStream, bos, limit == -1 ?
				// Integer.MAX_VALUE : limit);
				// bos.flush();
				// iStream = new SequenceInputStream(bos.getInputStream(),
				// iStream);
				// }

				// String queryString = IOUtils.toString(is,"UTF-8");
				// System.out.println("Post method : " + queryString);
				// URLDecoder.decode(queryString,"UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 * @return
	 */
	private String getUserIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	@Override
	public void handleFault(Message message) {
		System.out.println("Input Message Fault Handler.....");
		Exception exeption = message.getContent(Exception.class);
		System.out.println("Exception" + exeption.getMessage());
	}

	private String getContext(Message message) {

		StringBuilder sb = new StringBuilder();
		String ct = (String) message.get(Message.CONTENT_TYPE);

		InputStream is = message.getContent(InputStream.class);
		if (is != null) {
			logInputStream(message, is, sb, "UTF-8", ct);
		}

		return sb.toString();
	}

	private static Integer limit = 48 * 1024;

	protected void logInputStream(Message message, InputStream is, StringBuilder buffer, String encoding, String ct) {

		CachedOutputStream bos = new CachedOutputStream();

		try {
			// use the appropriate input stream and restore it later
			InputStream bis = is instanceof DelegatingInputStream ? ((DelegatingInputStream) is).getInputStream() : is;

			// only copy up to the limit since that's all we need to log
			// we can stream the rest
			
			IOUtils.copy(bis, bos); // 2.5.0
			//IOUtils.copyAtLeast(bis, bos, limit == -1 ? Integer.MAX_VALUE : limit); 3.1.0
			bos.flush();
			bis = new SequenceInputStream(bos.getInputStream(), bis);

			// restore the delegating input stream or the input stream
			if (is instanceof DelegatingInputStream) {
				((DelegatingInputStream) is).setInputStream(bis);
			} else {
				message.setContent(InputStream.class, bis);
			}

			writePayload(buffer, bos, encoding, ct);

			bos.close();
		} catch (Exception e) {
			throw new Fault(e);
		}
	}

	protected void writePayload(StringBuilder builder, CachedOutputStream cos, String encoding, String contentType)
			throws Exception {
		// Just transform the XML message when the cos has content
		if ((contentType != null && contentType.indexOf("xml") >= 0) && cos.size() > 0) {
			Transformer serializer = XMLUtils.newTransformer(2);
			// Setup indenting to "pretty print"
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			StringWriter swriter = new StringWriter();
			serializer.transform(new StreamSource(cos.getInputStream()), new StreamResult(swriter));
			String result = swriter.toString();
			if (result.length() < limit || limit == -1) {
				builder.append(swriter.toString());
			} else {
				builder.append(swriter.toString().substring(0, limit));
			}

		} else {
			if (StringUtils.isEmpty(encoding)) {
				cos.writeCacheTo(builder, limit);
			} else {
				cos.writeCacheTo(builder, encoding, limit);
			}

		}
	}

	/** 3.1.0
	protected void writePayload1(StringBuilder builder, CachedOutputStream cos, String encoding, String contentType)
			throws Exception {
		// Just transform the XML message when the cos has content
		if ((contentType != null && contentType.indexOf("xml") >= 0
				&& contentType.toLowerCase().indexOf("multipart/related") < 0) && cos.size() > 0) {

			StringWriter swriter = new StringWriter();
			XMLStreamWriter xwriter = StaxUtils.createXMLStreamWriter(swriter);
			xwriter = new PrettyPrintXMLStreamWriter(xwriter, 2);
			InputStream in = cos.getInputStream();
			try {
				StaxUtils.copy(new StreamSource(in), xwriter);
			} catch (XMLStreamException xse) {
				// ignore
			} finally {
				try {
					xwriter.flush();
					xwriter.close();
				} catch (XMLStreamException xse2) {
					// ignore
				}
				in.close();
			}

			String result = swriter.toString();
			if (result.length() < limit || limit == -1) {
				builder.append(swriter.toString());
			} else {
				builder.append(swriter.toString().substring(0, limit));
			}
		} else {
			if (StringUtils.isEmpty(encoding)) {
				cos.writeCacheTo(builder, limit);
			} else {
				cos.writeCacheTo(builder, encoding, limit);
			}
		}
	}
	*/
}
