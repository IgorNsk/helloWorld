package org.igorr.quickstarts.helloworld.beans.services.messages;

class ErrorMessage extends Message {

    ErrorMessage(String discription) {
        super(discription);
        type = "ErrorMessage:";
    }

}
