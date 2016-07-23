package org.raowei.test.pattern.responsibilitychain;

/**
 * @author terryrao on 2016/7/23.
 */
public class FilerChainClient {

    public static void main(String[] args) {
        Request request = new Request("被就业了：），敏感信息，<script>");
        Response response1 = new Response("response");

        FilterChain filterChain = new FilterChain();
        filterChain.add((req,resp) -> {
            req.setMsg(req.getMsg().replace("<","&lt;").replace(">","&gt;"));
            System.out.println("HtmlFilter");
            resp.setMsg(resp.getMsg() + "你妹");
        }).add((req,resp) -> {
            req.setMsg(request.getMsg().replace("敏感","&lt;").replace(">","&gt;"));
            System.out.println("textFilter");
            resp.setMsg(resp.getMsg() + "你妹");
        });

        filterChain.doFilter(request,response1);
//        System.out.println(request.getMsg());
//        System.out.println(response1.getMsg());

    }

}
