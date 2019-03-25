package org.raowei.test.enums;

import org.raowei.test.util.Generator;

import java.util.Iterator;

/**
 * Created by terryrao on 5/24/2015.
 */
public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;
    enum StateDuration{
        TRANSIENT;
    }


    enum State {
        RESTING{
            void next (Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount +=input.amount();
                        state =ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                        default:
                }
            }
        }, ADDING_MONEY {
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if(amount < selection.amount())
                            System.out.print("Insufficient money for " + selection);
                        else state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                System.out.print("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if(amount > 0) {
                    System.out.print("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL{
            void output() {
                System.out.print("print(halted)");
            }
        }
        ;
        private boolean isTransient = false;
        State() {}

        State(StateDuration stateDuration) {
            this.isTransient = true;
        }
        void next(Input input) {
            throw new RuntimeException("Only call new(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call new(Input input) for StateDuration-transient states");
        }
        void output(){
            System.out.println(amount);
        }

    }
    static void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
        }
        while (state.isTransient) {
            state.next();
        }
        state.output();
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
//        if(args.length == 1)
//            gen = new FileInputGenerator(args[0]);
        run(gen);
    }

// For a basic sanity check:


//    // Create Inputs from a file of ';'-separated strings:
//    class FileInputGenerator implements Generator<Input> {
//        private Iterator<String> input;
//        public FileInputGenerator(String fileName) {
//            input = new TextFile(fileName, ";").iterator();
//        }
//        public Input next() {
//            if(!input.hasNext())
//                return null;
//            return Enum.valueOf(Input.class, input.next().trim());
//        }
//    }
}
class RandomInputGenerator implements Generator<Input> {
    public Input next() { return Input.randomSelection(); }
}