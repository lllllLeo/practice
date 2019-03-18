String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};

$(".answerWrite input[type=submit]").click(addAnswer);

function addAnswer() {
    e.preventDefault(); // submit 이 자동으로 동작하는것을 막음
    // form 데이터들을 자동으로 묶어준다.
    var queryString = $("form[name=answer]").serialize();

    $.ajax({
        type : 'post',
        url : '/api/qna/addAnswer',
        data : queryString,
        dataType : 'json',
        error : onError,
        success : onSuccess,
    });
}

function onSuccess(json, status) {
  var answerTemplate = $("#answerTemplate").html();
  var template = answerTemplate.format(json.writer, new Date(json.createdDate), json.contents, json.answerId);
  $(".qna-comment-slipp-articles").prepend(template);
}

$(".qna-comment").click(deleteAnswer);

function deleteAnswer() {
  e.preventDefault();
  $.ajax({
      type : 'post',
      url : '/api/qna/deleteAnswer',
      data : $("#answerId").val(),
      dataType : 'json',
      error : function (xhr, status) {
        alert("error");
      },
      success : function (json, status) {
        if (json.status) {

        }

      }

  })

}
