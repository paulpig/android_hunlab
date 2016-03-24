package com.readboy.HandWrite;

/**
 * ��дʶ��JNI�ӿڣ�����˳��{@link #initHandWrite(String)}-->
 * [{@link #setReconizeEngilish()}|{@link #iHCR_SetParam(long, long)}...]-->
 * {@link #exitHandWriteInit()}�������ľ���ʵ����jni\Ŀ¼�µ�com_readboy_HandWrite.c��
 * @author css
 * @version 1.0
 */
public class HandWrite {
	
	static {
		System.loadLibrary("TestHandWrite");
	}

	/**
	 * ��ʼ��дʶ��
	 * @param ncout �ʻ�����������
	 * @param polongArray �ʻ�������
	 * @param resultArray ʶ��������buf
	 * @return ����ִ�гɹ��򷵻�ʶ�𵽵��ַ�(unicode����)���������򣬺���ִ�д��󣬱�����Ϊ-1��
	 * ��������״̬���󣬱�����Ϊ-2���������ò������󣬱�����Ϊ-3
	 */
	public static native int reconizePoint(int ncout, short[] polongArray,
			short[] resultArray);
	
	/**
	 * ��ʼ�� iHCR���棬�����ֵ���Դ����ʶ���ֵ�������ֵ䣩
	 * @param dataPath ָ���ֵ���Դ���ڵ��ڴ�λ�á�
	 * @return ��ʼ���ɹ����� 1��ʧ�ܷ��� 0
	 */
	public static native int initHandWrite(String dataPath);
	
	/**
	 * �ͷ��ڴ棬�˳� iHCR ���档
	 * @return ʼ��Ϊ1
	 */
	public static native int exitHandWriteInit();
	
	/**
	 * ����ֻʶ��Ӣ����ĸ�� 
	 * @return ʶ��Χ���óɹ����� 0������С�� 0
	 */
	public static native int setReconizeEngilish();

	/**
	 * ����ʶ�������
	 * @param paramName ���趨�Ĳ������ƣ��������Ʒ�Χ������ο�ö������iHCR_PARAM
	 * @param paramValue �趨����ֵ������ȡֵ��Χ������ο�ö������iHCR_PARAM
	 * @return ʶ��Χ���óɹ�����0������С�� 0
	 */
	public static native int iHCR_SetParam(long paramName, long paramValue);

	/**
	 * ��ʽ������д����
	 * @param left ��������д������߽�����ֵ���������Ϸ�ԭ����������ϵ��˵һ��Ϊ 0�� 
	 * @param right��������д�����ұ߽�����ֵ���������Ϸ�ԭ����������ϵ��˵һ��Ϊ��д����Ŀ��ֵ��
	 * @param top ��������д�����ϱ߽�����ֵ���������Ϸ�ԭ����������ϵ��˵һ��Ϊ 0��
	 * @param bottom ��������д�����±߽�����ֵ���������Ϸ�ԭ����������ϵ��˵һ��Ϊ��д����ĸ߶�ֵ��
	 * @return ���óɹ�����0������С�� 0
	 */
	public static native int HCR_SetWritingArea(long left, long right,
			long top, long bottom);

	/** iHCR ����ִ�гɹ���������Ϊ0   */
	public static long iHCR_OK = 0;
	/** ����ִ�д��󣬱�����Ϊ-1    */
	public static long iHCR_ERROR = -1;
	/** ��������״̬���󣬱�����Ϊ-2   */
	public static long iHCR_INVCAL = -2;
	/** �������ò������󣬱�����Ϊ-3    */
	public static long iHCR_INVARG = -3;
	/** ��Դ���󣬱�����Ϊ-4    */
	public static long iHCR_RESERROR = -4;

	public static long iHCR_LANGUAGE_NONE = 0x00000000;
	/* a-z */
	public static long iHCR_LANGUAGE_English_LowerCase = 0x00000001;
	/* A-Z */
	public static long iHCR_LANGUAGE_English_UpperCase = 0x00000002;
	/* lowercase and uppercase */
	public static long iHCR_LANGUAGE_English = iHCR_LANGUAGE_English_LowerCase
			| iHCR_LANGUAGE_English_UpperCase;

	/*
	 * longerpunctions:
	 * 0x0021-0x002F=0xFF01-0xFF0F;,0x003A-0x0040=0xFF1A-0xFF20;,
	 */
	/*
	 * 0x005B-0x0060=0xFF3B-0xFF40;,0x007B-0x007E=0xFF5B-0xFF5E;,
	 * 0x00A2=0xFFE0;,
	 */
	/* 0x00A3=0xFFE1;,0x00A5=0xFFE5;,0x00B0,0x00D7,0x00F7, 0x2014,0x2018,0x2019, */
	/*
	 * 0x201C,0x201D,0x2022,0x2026,0x2030,0x2032,0x2033,0x20AC,0x2103,0x221A,0x2236
	 * ,
	 */
	/* 0x3001,0x3002,0x3008,0x3009,0x300A,0x300B */
	public static long iHCR_LANGUAGE_Symbols = 0x00000004;
	/* 0-9 */
	public static long iHCR_LANGUAGE_Numerals = 0x00000008;
	/* space=0x0020;, enter=0x000D;, backspace=0x0008;, delete=0x001E; */
	public static long iHCR_LANGUAGE_Gestures = 0x00000010;

	public static long iHCR_LANGUAGE_REGION_Mask = 0xF0000000;
	public static long iHCR_LANGUAGE_REGION_European = 0x10000000;
	public static long iHCR_LANGUAGE_REGION_African = 0x20000000;
	public static long iHCR_LANGUAGE_REGION_MiddleEastern = 0x30000000;
	public static long iHCR_LANGUAGE_REGION_American = 0x40000000;
	public static long iHCR_LANGUAGE_REGION_Indic = 0x50000000;
	public static long iHCR_LANGUAGE_REGION_Philippine = 0x60000000;
	public static long iHCR_LANGUAGE_REGION_SouthEastAsian = 0x70000000;
	public static long iHCR_LANGUAGE_REGION_EastAsian = 0x80000000;
	public static long iHCR_LANGUAGE_REGION_CentralAsian = 0x90000000;
	public static long iHCR_LANGUAGE_REGION_AncientAsian = 0xA0000000;
	public static long iHCR_LANGUAGE_REGION_Other = 0xB0000000;

	public static long iHCR_LANGUAGE_German = iHCR_LANGUAGE_REGION_European | 0x00000100;
	public static long iHCR_LANGUAGE_French = iHCR_LANGUAGE_REGION_European | 0x00000200;
	public static long iHCR_LANGUAGE_Italy = iHCR_LANGUAGE_REGION_European | 0x00000400;
	public static long iHCR_LANGUAGE_Spanish = iHCR_LANGUAGE_REGION_European | 0x00000800;
	public static long iHCR_LANGUAGE_Portuguese = iHCR_LANGUAGE_REGION_European | 0x00001000;
	public static long iHCR_LANGUAGE_Polish = iHCR_LANGUAGE_REGION_European | 0x00002000;
	public static long iHCR_LANGUAGE_Dutch = iHCR_LANGUAGE_REGION_European | 0x00004000;
	public static long iHCR_LANGUAGE_Czech = iHCR_LANGUAGE_REGION_European | 0x00008000;
	public static long iHCR_LANGUAGE_Hungarian = iHCR_LANGUAGE_REGION_European | 0x00010000;
	public static long iHCR_LANGUAGE_Danish = iHCR_LANGUAGE_REGION_European | 0x00020000;
	public static long iHCR_LANGUAGE_Finnish = iHCR_LANGUAGE_REGION_European | 0x00040000;
	public static long iHCR_LANGUAGE_Icelandic = iHCR_LANGUAGE_REGION_European | 0x00080000;
	public static long iHCR_LANGUAGE_Norwegian = iHCR_LANGUAGE_REGION_European | 0x00100000;
	public static long iHCR_LANGUAGE_Swedish = iHCR_LANGUAGE_REGION_European | 0x00200000;
	public static long iHCR_LANGUAGE_Turkish = iHCR_LANGUAGE_REGION_European | 0x00400000;
	public static long iHCR_LANGUAGE_Russian = iHCR_LANGUAGE_REGION_European | 0x00800000;
	public static long iHCR_LANGUAGE_Serbian = iHCR_LANGUAGE_REGION_European | 0x01000000;
	public static long iHCR_LANGUAGE_Greek = iHCR_LANGUAGE_REGION_European | 0x02000000;
	public static long iHCR_LANGUAGE_Macedonian = iHCR_LANGUAGE_REGION_European | 0x04000000;

	public static long iHCR_LANGUAGE_Arabic = iHCR_LANGUAGE_REGION_MiddleEastern | 0x00000100;
	/* Not supported yet */
	public static long iHCR_LANGUAGE_Hebrew = iHCR_LANGUAGE_REGION_MiddleEastern | 0x00000200;

	public static long iHCR_LANGUAGE_Thai = iHCR_LANGUAGE_REGION_SouthEastAsian | 0x00000100;
	public static long iHCR_LANGUAGE_Vietnamese = iHCR_LANGUAGE_REGION_SouthEastAsian | 0x00000200;

	/* GB2312, total number: 6763 */
	public static long iHCR_LANGUAGE_Chinese_GB = iHCR_LANGUAGE_REGION_EastAsian | 0x00000200;
	/* GBK, total number: 21003 */
	public static long iHCR_LANGUAGE_Chinese_GBK = iHCR_LANGUAGE_REGION_EastAsian | 0x00000100;
	/* Big5, total number: 13053 */
	public static long iHCR_LANGUAGE_Chinese_Big5 = iHCR_LANGUAGE_REGION_EastAsian | 0x00000400;
	public static long iHCR_LANGUAGE_Chinese_Symbols = iHCR_LANGUAGE_REGION_EastAsian | 0x00000800;
	public static long iHCR_LANGUAGE_Hangul = iHCR_LANGUAGE_REGION_EastAsian | 0x00004000;
	public static long iHCR_LANGUAGE_Japanese_Hiragana = iHCR_LANGUAGE_REGION_EastAsian | 0x00008000;
	public static long iHCR_LANGUAGE_Japanese_Katagana = iHCR_LANGUAGE_REGION_EastAsian | 0x00010000;
	public static long iHCR_LANGUAGE_Japanese_Kanji = iHCR_LANGUAGE_REGION_EastAsian | 0x00020000;

	/* toggle recognition support for cursive strokes */
	public static long iHCR_RECOGNITION_CURSIVE = 0x0001;
	/* toggle recognition support for slant handwritten word */
	public static long iHCR_RECOGNITION_SLANT = 0x0002;
	/* toggle recognition support for disorder written strokes */
	public static long iHCR_RECOGNITION_DISORDERED = 0x0004;
	/* toggle recognition support for rotated handwritten word */
	public static long iHCR_RECOGNITION_ROTATION = 0x0008;
	public static long iHCR_RECOGNITION_DEFAULT = iHCR_RECOGNITION_CURSIVE;

	public static long iHCR_RECOGNITION_CONFIG_FLAG = 0xF000;
	/* default recognition manner, treat input polongs as character */
	public static long iHCR_RECOGNITION_CHAR = 0x1000;
	/* treat input polongs as sentence, *new* in iHCR3.0 */
	public static long iHCR_RECOGNITION_SENT_MASK = 0x2000;
	/* treat input polongs as sentence written in a line */
	public static long iHCR_RECOGNITION_SENT_LINE = iHCR_RECOGNITION_SENT_MASK | 0x0001;
	/* treat input polongs as sentence written in full-screen */
	public static long iHCR_RECOGNITION_SENT_FS = iHCR_RECOGNITION_SENT_MASK | 0x0002;
	/* treat input polongs as sentence written overlaply */
	public static long iHCR_RECOGNITION_SENT_OVLP = iHCR_RECOGNITION_SENT_MASK | 0x0003;

	/* new function in iHCR2.1 */
	/* a one-stop recognition function */

	public static long iHCR_ACTION_Recognition = 0x00000000;
	public static long iHCR_ACTION_Trad2Simp = 0x00000001;
	public static long iHCR_ACTION_Simp2Trad = 0x00000002;
	public static long iHCR_ACTION_Homophone = 0x00000003;
	public static long iHCR_ACTION_Adaptation = 0x00000004;
	public static long iHCR_ACTION_Reset = 0x00000005;

	public static long iHCR_USERDICT_SIZE = 96 * 1024;
	public static long iHCR_USERWORD_SIZE = 8 * 1024;
	
	public enum iHCR_PARAM
    {
        /* parameter indicating recognition range */
        /* supported value range: iHCR_LANGUAGE_* and their '|' combination */
        /* with iHCR_LANGUAGE_ flag of english/numeral/symbols */
        iHCR_PARAM_LANGUAGE,

        /* parameter indication recognition mode */
        /* support value range: iHCR_RECONIGTION_CURSIVE, iHCR_RECOGNITION_SLANT, */
        /* iHCR_RECOGNITION_DISORDERED, iHCR_RECOGNITION_ROTATION and their '|' combination */
        iHCR_PARAM_RECOGMODE,

        /* parmeter indicating recognition engine's working manner, *new* in 3.0 */
        /* supported value range: iHCR_RECOGNITION_CHAR, iHCR_RECOGNITION_SENT_LINE, */
        /* iHCR_RECOGNITION_SENT_FS, iHCR_RECOGNITION_SENT_OVLP */
        iHCR_PARAM_RECOGMANNER,

        /* parameter indication maximum word number of returned recognition result */
        iHCR_PARAM_MAXCANDNUM
    } 

}
