package controller;

import http.HttpMethod;
import http.HttpRequest;
import http.HttpResponse;


public class AbstractController implements Controller {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        HttpMethod method = request.getMethod();

        if(method.isPost()){
            doPost(request, response);
        } else {
            doGet(request, response);
        }
    }


//  private은 자식클래스에서 접근불가라 protected 해야함
    protected void doGet(HttpRequest request, HttpResponse response) {}

    protected void doPost(HttpRequest request, HttpResponse response) {}
}
