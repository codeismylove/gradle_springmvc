package util;

public enum CodeStyle {
	ISO_8859_1("iso-8859-1"),
	GB_2312("gb2312"),
	GBK("gbk"),
	GB_18030("gb18030"),
	UTF_16("utf-16"),
	UTF_8("utf-8");
	
	private String value;  
    
	CodeStyle(String value) {  
        this.value = value;  
    }  
      
    public String getValue() {  
        return value;  
    }  
}
