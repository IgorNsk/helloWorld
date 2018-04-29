package org.igorr.quickstarts.helloworld.beans.services.messages;

abstract class Message {
    String type;
    private String discription;

    Message(String discription) {
        this.discription = discription;
    }


    Message get() {
        return this;
    }

    String getMessage(){
        StringBuilder sb = new StringBuilder();
        return sb.append(type).append(":").append(discription).toString();
    }
}
