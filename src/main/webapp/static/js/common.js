var AJAX = {
    get:function (url,data,method) {
        $.ajax({
            url:url,
            data:data,
            type:"get",
            async: false,
            success:function (res) {
                method(res);
            }
        })
    },
    post:function (url,data,method) {
        $.ajax({
            url:url,
            data:data,
            type:"post",
            async: false,
            success:function (res) {
                method(res);
            }
        })
    },
    get1:function (url,data,method) {
        $.ajax({
            headers:{
                token:$.cookie("token")
            },
            url:url,
            data:data,
            type:"get",
            async: false,
            success:function (res) {
                method(res);
            }
        })
    },
    post1:function (url,data,method) {
        $.ajax({
            headers:{
                token:$.cookie("token")
                ,userEmail:$.cookie("userEmail")
            },
            url:url,
            data:data,
            type:"post",
            async: false,
            success:function (res) {
                method(res);
            }
        })
    }
}
