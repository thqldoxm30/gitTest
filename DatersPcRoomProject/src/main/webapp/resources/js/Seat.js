var aa = [  0,0,0,1,0,0,0,1,0,1,0,
    0,1,1,1,0,0,0,0,1,0,0,0,1,0,1,0,
    0,1,1,1,0,0,0,0,1,0,0,0,1,0,1,0,
    0,1,1,1,0,0,0,0,1,0,0,0,1,0,1,0,
    0,1,1,1,0,0,0,0,1,0,0,0,1,0,1,0,
    0,1,1,1,0,0,0,0,1,0,0,0,1,0,1,0,
    0,1,1,1,0,0];
   for (i = 0; i < aa.length; i++) {
       if(aa[i] == 0){
           document.querySelector("#hi").innerHTML += '<td class="on"><label for="'+(i+1)+'"><img src="./images/mnt0.png"></label><input type="radio" name ="seat" id="'+(i+1)+'" value="'+(i+1)+'" class="a">'+(i+1)+"</td>";
        } else{
            document.querySelector("#hi").innerHTML += '<td class="off"><img src ="./images/mnt1.png">'+(i+1)+'</td>';
        }
    }
    document.querySelector("#zz").innerHTML = '<td><input type="submit" value ="앉기"></input></td>'
    $(document).ready(function () {
        $('td.on').click(function () {
            if ($(this).hasClass('on')) {
                $('td.check').addClass('on');
                $(this).addClass('check');
                $('td.on').find('img').attr("src", "./images/mnt0.png");
                $(this).find("img").attr("src", "./images/mnt2.png");
            }
        });
    });
