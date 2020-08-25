package ru.q1w2e3.myLinkedList;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class MainAppLauncher {
    @RunWith(Suite.class)
    @Suite.SuiteClasses({MyLinkedListTest.class})
    public class SuiteTestClass {
    }
}
