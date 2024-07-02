package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CartStep {
    public final SelenideElement
            cartProduct = $x("//div[@id='headerCartDynamic']/div").as("Корзина продуктовая");
    ////div[@class='CartProduct_titleContainer__T0ICj']
    String productPrice;

    @Когда("^запоминаем сумму продукта '([^']*)'$")
    public void rememberProductPrice(String price) {
        productPrice = $x("(//a[@data-product-price ='" + price + "'])[1]").getText();
    }

    @Когда("^добавляем продукт в корзину с наименованием '([^']*)'$")
    public void addProductToCart(String product) {
        $x("//a[@data-product-name='" + product + "']/span/span").shouldBe(Condition.visible).click();
        sleep(5000);
    }

    @Когда("^переходим в продуктовую корзину$")
    public void clickProductCart() {
        cartProduct.click();
        switchTo().window(1, Duration.ofSeconds(5));
    }

    @Тогда("^сравниваем сумму в корзине с запомненной суммой$")
    public void comparePrices() {

        String cartPrice = $x("(//div[@class='CartProduct_productPrice__1lW-7']/span)[1]").getText();

        int productPriceInt = Integer.parseInt(productPrice.replaceAll("[^\\d]", ""));
        int cartPriceInt = Integer.parseInt(cartPrice.replaceAll("[^\\d]", ""));

        if (cartPriceInt > productPriceInt) {
            System.out.println("Сумма в корзине больше запомненной суммы");
        } else if (cartPriceInt < productPriceInt) {
            System.out.println("Сумма в корзине меньше запомненной суммы");
        } else if (cartPriceInt == productPriceInt) {
            throw new AssertionError("Ошибка! Сумма в корзине равна 10000 р");
        }
    }
}
