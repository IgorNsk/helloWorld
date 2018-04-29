package org.igorr.quickstarts.helloworld.beans.generics;

public interface Transaction<E> {
    E begin();
}
