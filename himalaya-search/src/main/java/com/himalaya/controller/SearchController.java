package com.himalaya.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.himalaya.solr.client.QueryClient;

@Component("controller")
@RequestMapping("/search")
public class SearchController {

	private final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	private QueryClient tagService;

	@RequestMapping(value = "/tags", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String searchTags(@RequestParam("keyWords") String keyWords,
			@RequestParam("currentPage") int currentPage, @RequestParam("rows") int rows) {

		logger.info("searching tags keyWords:{}, currentPage:{}, rows:{}", new Object[] { keyWords });

		String tagsJSON = null;

		try {

			tagsJSON = tagService.queryTags(keyWords, rows, currentPage);
			logger.debug("tags : {} ", tagsJSON);
			return tagsJSON;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Searching tags error, msg:", e.getMessage());
		}

		return tagsJSON;
	}

	@RequestMapping(value = "/hotTags", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String searchHotTags() {

		logger.info("searching hot tags");

		String tagsJSON = null;

		try {			
			tagsJSON = tagService.queryHotestTags("*:*", 5, 0);
			logger.debug("tags : {} ", tagsJSON);
			return tagsJSON;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Searching hotest tags error, msg:", e.getMessage());
		}

		return tagsJSON;
	}

	/**
	 * @RequestMapping(value="/hello/{name}", produces=
	 *                                        "application/json;charset=UTF-8",
	 *                                        method=RequestMethod.GET) public
	 *                                        String hello(@PathVariable String
	 *                                        name){
	 * 
	 *                                        logger.info("Hi {}", name );
	 * 
	 *                                        return "search"; }
	 * 
	 * @RequestMapping(value="/hi", produces="application/json;charset=UTF-8",
	 *                              method=RequestMethod.GET) public String
	 *                              hi(@CookieValue(value="sessionid",
	 *                              required=false) String
	 *                              sessionId, @RequestHeader("Accept-Language")
	 *                              String acceptLanguage, @RequestParam("name")
	 *                              String name){
	 * 
	 *                              logger.info("Hi {}", name ); logger.info(
	 *                              "Hi acceptLanguage {}", acceptLanguage );
	 *                              logger.info("Hi JSESSIONID {}", sessionId );
	 * 
	 *                              return "search"; }
	 * 
	 * @RequestMapping(value="/h2", produces="application/json;charset=UTF-8",
	 *                              method=RequestMethod.GET) public
	 *                              ModelAndView
	 *                              h2(@RequestParam(value="name",required=
	 *                              false) String name){
	 * 
	 *                              logger.info("H2 {}", name );
	 * 
	 *                              ModelAndView mv = new ModelAndView();
	 *                              mv.setViewName("search");
	 * 
	 *                              return mv; }
	 */

	/**
	 * http://localhost:8080/solrService/search/h3?name=fred&address.province=
	 * hunan
	 *
	 * @RequestMapping(value="/h3", produces="application/json;charset=UTF-8",
	 *                              method=RequestMethod.GET) public
	 *                              ModelAndView h3(User user){
	 * 
	 *                              logger.info("H3 {} , {}", user.getName(),
	 *                              user.getAddress().getProvince());
	 * 
	 *                              ModelAndView mv = new ModelAndView();
	 *                              mv.setViewName("search");
	 * 
	 *                              return mv; }
	 */

	/**
	 * Test JSON http://localhost:8090/solrService/search/h4/hello fred
	 * 
	 * @param msg
	 * @return
	 *
	 * @RequestMapping(value = "/h4/{msg}", produces =
	 *                       "application/json;charset=UTF-8")
	 *                       public @ResponseBody String say(@PathVariable(value
	 *                       = "msg") String msg) { float a = 0.2345f; float b =
	 *                       0.98789f; float c = 0; int i = 0; while(i<10000){ c
	 *                       = c + a*b*a*b + a + b; } msg = msg + c ;
	 *                       logger.info("H4 {}", msg); return
	 *                       "{\"msg\":\"you say:'" + msg + "'\"}"; }
	 */
}
