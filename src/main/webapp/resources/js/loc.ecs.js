$(document).ready(function(){
    $(".addtocart").submit(function (event) {
        event.preventDefault();

        var $form = $(this), url = $form.attr("action");

        if ($form.children('.buy').text() == "Купить") {
            $.post({
                url: url,
                success: function (data) {
                    document.getElementById("cart_count").innerHTML = "Товаров: " + data;
                    $form.children('.buy').text("В корзине");
                }
            });
        }
        else {
            document.open().location.pathname="/cart";
        }
    });

    var fadeTime = 0;
    /* Assign actions */
    $('.product-quantity input').change( function() {
        updateQuantity(this);
    });

    $('.product-removal button').click( function() {
        var product_id = this.id;
        var url = "/cart/remove?uid=1&pid=" + product_id;

        $.post({
            url: url,
            success: function (data) {
                if (data == 0) {
                    document.getElementById("cart_count").innerHTML = "Нет товаров";
                }
                else {
                    document.getElementById("cart_count").innerHTML = "Товаров: " + data;
                }
            }
        });
        removeItem(this);
    });

    /* Recalculate cart */
    function recalculateCart()
    {
        var subtotal = 0;

        /* Sum up row totals */
        $('.product').each(function () {
            subtotal += parseInt($(this).children('.product-line-price').text());
        });

        /* Calculate totals */
        var total = subtotal;

        /* Update totals display */
        $('.totals-value').fadeOut(fadeTime, function() {
            $('#cart-total').html(total);
            $('.totals-value').fadeIn(fadeTime);
        });
    }

    /* Update quantity */
    function updateQuantity(quantityInput)
    {
        /* Calculate line price */
        var productRow = $(quantityInput).parent().parent();
        var price = productRow.children('.product-price').text();
        var quantity = $(quantityInput).val();
        var linePrice = price * quantity;

        /* Update line price display and recalc cart totals */
        productRow.children('.product-line-price').each(function () {
            $(this).text(linePrice);
            recalculateCart();
        });
    }
    /* Remove item from cart */
    function removeItem(removeButton)
    {
        /* Remove row from DOM and recalc cart total */
        var productRow = $(removeButton).parent().parent();
        productRow.slideUp(400, function() {
            productRow.remove();
            recalculateCart();
        });
    }

    recalculateCart();

});