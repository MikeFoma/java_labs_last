package com.company;

public class Robot {

    private final Object monitor = new Object();

    class Leg implements Runnable {
        private final String name;

        Leg(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(true) {
                synchronized (monitor) {
                    try {
                        step();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    monitor.notify();
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void step() throws InterruptedException {
            System.out.println(name);
            Thread.sleep(1000);
        }
    }

    Leg left = new Leg("Шаг Левой");
    Leg right = new Leg("Шаг Правой");

    void run() {
        new Thread(left).start();
        new Thread(right).start();
    }

    public static void main(String[] args) {
        new Robot().run();
    }
}
