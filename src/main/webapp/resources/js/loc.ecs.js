$(document).ready(function(){
    $(".addtocart").submit(function (event) {
        event.preventDefault();

        var $form = $(this ), url = $form.attr("action");

        $.post({
            url: url,
            success: function(data) {
                document.getElementById("cart_count").innerHTML="Товаров: " + data;
            }
        });
    });

    $(".removefromcart").submit(function (event) {
        event.preventDefault();

        var $form = $(this), url = $form.attr("action");

        $.post({
            url: url,
            success: function (data) {
                document.getElementById("cart_count").innerHTML="Товаров : " + data;
            }
        })
    })
});