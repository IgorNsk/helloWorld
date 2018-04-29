package org.igorr.quickstarts.helloworld.beans.services.messages;

class SuccessMessage extends Message {
    SuccessMessage(String discription) {
        super(discription);
        type = "SuccessMessage:";
    }
}
