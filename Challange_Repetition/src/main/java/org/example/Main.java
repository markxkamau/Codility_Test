package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Source source =  new Source("wlylcee", "auboksw");
        int count = source.solution();
        System.out.println("Min Distinct :" + count);
    }
}

