package org.raowei.test.enums;

/**
 * Created by terryrao on 5/23/2015.
 */
public interface Food {
    enum Appettizer implements Food {
        SALAD,SOUP,SPRING_ROLLS
    }

    enum MainCoures implements Food {
        LASAGNE,BURRIID,PAD_THAI
    }

    enum  Dessert implements Food {
        tiramisu,GELATO,FRUIT
    }

}
