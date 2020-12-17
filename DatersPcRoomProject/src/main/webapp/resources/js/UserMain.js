$(document).ready(function(){
    $("div.top").click(function(){
        $("body").scrollTop(0);
    });
    $("div.rec").mouseover(function(){
        $(this).css("background-color", "black");
      });
      $("div.rec").mouseout(function(){
        $("div.rec").css("background-color", "dimgray");
      });
})
