package org.raowei.test.enums;

import java.util.EnumMap;

import static org.raowei.test.enums.Input.*;

/**
 * Created by terryrao on 5/24/2015.
 */
public enum Category {
    MONEY(NICKEL, DIME, QUARRTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private Input[] inputs;

    Category(Input... inputs) {
        this.inputs = inputs;
    }

    Category() {
    }

    private static EnumMap<Input, Category> categories = new EnumMap<>(Input.class);

    static {
        for (Category category : Category.class.getEnumConstants()) {
            for (Input type : category.inputs) {
                categories.put(type, category);
            }
        }
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}
