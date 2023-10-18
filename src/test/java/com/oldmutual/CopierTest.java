package com.oldmutual;

import mockit.Verifications;
import mockit.integration.junit5.JMockitExtension;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
class CopierTest {

    @Test
    public void CopyCopiesCharactersUntilNewlineTest() {
        ISource source = mock(ISource.class);
        IDestination destination = mock(IDestination.class);
        when(source.readChar()).thenReturn('H', 'e', 'l', 'l', 'o', '\n');

        Copier copier = new Copier(source, destination);

        copier.copy();

        verify(destination, times(5)).writeChar(anyChar());
    }
}
