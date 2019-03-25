package org.raowei.test.learnjunit.chapter12;


import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Node;

import java.io.IOException;

/**
 * ${DESCRIPTION}
 * create: 2016-07-20 17:59
 *
 * @author admin
 */
public class JavaDocPageTest {


    @Test
    public void testClassNav() throws IOException {
        WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net/apidocs/index.html");
        HtmlPage packageFrame = (HtmlPage) page.getFrameByName("packageFrame").getEnclosedPage();
        HtmlPage bVerPage = packageFrame.getAnchorByHref("com/gargoylesoftware/htmlunit/BrowserVersion.html").click();
        HtmlParagraph p = (HtmlParagraph) bVerPage.getElementsByTagName("p").item(0);
        Assert.assertTrue("Unexpected text",p.asText().startsWith(
                "Objects of this class represent one specific version of a given"));
        webClient.close();


    }

}
