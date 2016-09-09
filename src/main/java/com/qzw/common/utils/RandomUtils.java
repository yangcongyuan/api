package com.qzw.common.utils;

import java.util.Random;

public class RandomUtils 
{
	public static String getValiCode()
	{
		int len = 6;
		Random random = new Random();
		StringBuilder valiCode = new StringBuilder();
		for( int i = 0; i < len; i++ )
		{
			valiCode.append(random.nextInt(10));
		}
		return valiCode.toString();
	}
	
	public static String getIdTag()
	{
		int len = 7;
		String[] chr = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		Random random = new Random();
		StringBuilder idtag = new StringBuilder();
		for( int i = 0; i < len; i++ )
		{
			if( random.nextInt(2) == 0 )
			{
				idtag.append(random.nextInt(10));
			}
			else 
			{
				idtag.append(chr[random.nextInt(26)]);
			}
		}
		return idtag.toString();
	}

}
