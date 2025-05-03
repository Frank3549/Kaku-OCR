package com.kakutools.kaku.XmlParsers.JmDict.JmDTO;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

import com.kakutools.kaku.XmlParsers.CommonParser;
import com.kakutools.kaku.XmlParsers.JmDict.JmConsts;

/**
 * Created by 0xbad1d3a5 on 4/30/2016.
 */
public class JmLsource {

    private static final String XMLTAG = JmConsts.LSOURCE;

    private String text = null;
    private String lang = null;
    private String ls_type = null;
    private String ls_wasei = null;

    public JmLsource(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, XMLTAG);

        HashMap<String, String> attrMap = CommonParser.parseAttributes(parser);
        lang = attrMap.get(JmConsts.XML_LANG) == null ? "eng" : attrMap.get(JmConsts.XML_LANG);
        ls_type = attrMap.get(JmConsts.LS_TYPE);
        ls_wasei = attrMap.get(JmConsts.LS_WASEI);
        text = CommonParser.parseString(parser);
    }

    public String getText(){
        return text;
    }

    public String getLang(){
        return lang;
    }

    public String getLsType(){
        return ls_type;
    }

    public String getLsWasei(){
        return ls_wasei;
    }
}
