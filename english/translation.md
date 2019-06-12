### FlashMap

FlashMap은 한 요청이 다른 요청에서 사용하기 위해 만들어진 attributes를 저장하는 방법을 제공한다. 이는 한 URL에서 다른 URL로 redirect할 떄 가장 흔하게/일반적으로 필요하다. 예를 들어, POST/Redirect/Get 패턴.
FlashMap은 redirect하기 전에 저장되고 (일반적으로 세션에 저장됨) redirect 후에 사용가능하게/사용할 수 있게 만들어졌고 즉시 삭제된다.   
FlashMap은 요청 경로 및 요청 매개변수들을 가지고 설정하여서 타겟 요청 식별하는 것에 도움이 된다.
이 정보가 없으면 다음 요청에서 사용할 수 있는 FlashMap은 의도된 받는 사람이 될 수도 있고 아닐 수도 있다. redirect에서 대상 URl을 알고 FlashMap은 저 정보를 사용하여 업데이트를 할 수 있다. 이것은 `org.springframework.web.servlet.view.RedirectView `를 사용 할 때 자동적으로 사용된다. / 수행된다.

A FlashMap provides a way for one request to store attributes intended for use in another. This is most commonly needed when redirecting from one URL to another -- e.g. the Post/Redirect/Get pattern. A FlashMap is saved before the redirect (typically in the session) and is made available after the redirect and removed immediately.  
A FlashMap can be set up with a request path and request parameters to help identify the target request. Without this information, a FlashMap is made available to the next request, which may or may not be the intended recipient. On a redirect, the target URL is known and a FlashMap can be updated with that information. This is done automatically when the org.springframework.web.servlet.view.RedirectView is used.

- FlashMap은 Redirect전 session과 같은 장소에 저장한뒤 redirect 후 즉시 삭제한다. Post 방식과 비슷하게 URL에 Parameter를 노출하지 않고 전달하게 된다. 

```java
  ..., RedirectAttributes attribute) {
    // attributes.addAttribute("attr", "attribute"); GET 방식으로 parameter가 URL에 노출됨
    attributes.addFlashAttribute("attr", "attribute");
  }
```
https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/FlashMap.html

