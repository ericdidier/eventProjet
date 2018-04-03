package be.formation.backend.enums;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SendingModeEnumTest {

    private static final SendingModeEnum SENDING_MODE_ENUM = SendingModeEnum.SEND_FOR_EMAIL;

    @Test
    public void testSendingModeEnumTestEnum() throws Exception {
        Assert.assertEquals(SENDING_MODE_ENUM.getValue(), "0");
    }

}