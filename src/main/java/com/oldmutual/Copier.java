package com.oldmutual;

public class Copier {
    private final ISource source;
    private final IDestination destination;

    public Copier(ISource source, IDestination destination) {
        this.source = source;
        this.destination = destination;
    }

    public void copy() {
        char currentChar;
        while ((currentChar = source.readChar()) != '\n') {
            destination.writeChar(currentChar);
        }
    }

    public void copyMultiple(int count) {
        char[] buffer = source.readChars(count);
        int newlineIndex = -1;

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == '\n') {
                newlineIndex = i;
                break;
            }
        }

        if (newlineIndex >= 0) {
            destination.writeChars(buffer, newlineIndex);
        } else {
            destination.writeChars(buffer, buffer.length);
            copyMultiple(count); // Continue copying until a newline is encountered
        }
    }
}

