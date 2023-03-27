package HomeWork_1_0.Äç1.Behavioral.ChainOfResponsibility;

abstract class MessagePrinter {
    MessagePrinter nextMessagePrinter;
    public void setNextMessagePrinter(MessagePrinter nextMessagePrinter) {
        this.nextMessagePrinter = nextMessagePrinter;
    }
    void print(String message){
        printMessage(message);
        if(nextMessagePrinter!=null){
            nextMessagePrinter.print(message);
        }

    }
    abstract void printMessage(String message);

}
