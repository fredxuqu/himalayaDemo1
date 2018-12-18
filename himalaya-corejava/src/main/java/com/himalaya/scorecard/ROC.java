package com.himalaya.scorecard;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2018年11月29日 下午2:27:43 Description

	 		1			0.9		0.90
			2			0.8		0.80
			3			0.3		0.70
			4			0.6		0.60
			5			0.55	0.55
			6			0.54	0.54
			7			0.33	0.53
			8			0.32	0.52
			9			0.51	0.51
			10			0.40	0.45
			11			0.50	0.40
			12			0.39	0.39
			13			0.48	0.38
			14			0.37	0.37
			15			0.36	0.36
			16			0.35	0.35
			17			0.64	0.34
			18			0.33	0.33
			19			0.53	0.30
			20			0.10	0.10
			
			1			p		0.90
			2			p		0.80
			3			n		0.70
			4			p		0.60
			5			p		0.55
			6			p		0.54
			7			n		0.53
			8			n		0.52
			9			p		0.51
			10			n		0.45
			11			p		0.40
			12			n		0.39
			13			p		0.38
			14			n		0.37
			15			n		0.36
			16			n		0.35
			17			p		0.34
			18			n		0.33
			19			p		0.30
			20			n		0.10
		predicted:	0.9, 0.8, 0.7, 0.6, 0.55, 0.54, 0.53, 0.52, 0.51, 0.45, 0.4, 0.39, 0.38, 0.37, 0.36, 0.35, 0.34, 0.33, 0.3, 0.1	
	
		producted:	1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0
 */
public class ROC {
	public static double[][] getROC(double thershold, double[] product, double[] predict) { // thershold是阈值，也就是基准
		if (product.length != predict.length)
			throw new IllegalStateException("长度必须一致");
		else if (product.length == 0 || predict.length == 0 || product == null || predict == null)
			throw new IllegalStateException("请传入有参数的数值");
		System.out.println("origin data: " + product.toString() + "\t" + "predict data: " + predict);
		double sumTp = 0.0;
		double sumFn = 0.0;
		double sumFp = 0.0;
		double sumTn = 0.0;

		double tpr = 0.0;
		double fpr = 0.0;

		int len = product.length;

		double[] X = new double[len];
		double[] Y = new double[len];

		for (int i = 0; i < len; i++) { // 后面的product[i], 可以用自己想要的维度来替换
			if ((Math.abs(product[i] - predict[i]) / product[i] > thershold) & (product[i] > 0.45) == true)
				sumTp += 1.0;
			if ((Math.abs(product[i] - predict[i]) / product[i] > thershold) & (product[i] > 0.45) == false)
				sumFn += 1.0;
			if ((Math.abs(product[i] - predict[i]) / product[i] < thershold) & (product[i] > 0.45) == true)
				sumFp += 1.0;
			if ((Math.abs(product[i] - predict[i]) / product[i] < thershold) & (product[i] > 0.45) == false)
				sumTn += 1.0;

			if (sumTp == 0.0)
				tpr = 0.0;
			else
				tpr = sumTp / (sumTp + sumFn);

			if (sumFp == 0.0)
				fpr = 0.0;
			else
				fpr = sumFp / (sumFp + sumTn);

			X[i] = fpr;
			Y[i] = tpr;

		} // 为了画出一个曲线，所以我选择存入二维数组中

		double[][] roc = { X, Y };

		return roc;
	}
	
	
	public static void main(String[] args) {
		double thershold = 0.45;
		double[] product = {0.9, 0.8, 0.3, 0.6, 0.55, 0.54, 0.33, 0.32, 0.51, 0.4, 0.5, 0.39, 0.48, 0.37, 0.36, 0.35, 0.64, 0.33, 0.53, 0.1};
		double[] predict = {0.9, 0.8, 0.7, 0.6, 0.55, 0.54, 0.53, 0.52, 0.51, 0.45, 0.4, 0.39, 0.38, 0.37, 0.36, 0.35, 0.34, 0.33, 0.3, 0.1};
		
		double[][] roc = getROC(thershold, product, predict);
		for (int i = 0; i < roc.length; i++) {
			double[] items = roc[i];
			for (double d : items) {
				System.out.print(d + "\t");
			}
			System.out.println();
		}
	}
}
