package org.igorr.quickstarts.helloworld.beans.generics;

public interface MessageManager {
    <M> M get(Transaction<M> var);
    <M> M get(M var);
}
