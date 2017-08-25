package org.testmonkeys;

import com.automation.remarks.junit.VideoRule;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.jayway.awaitility.core.ConditionTimeoutException;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testmonkeys.koshmar.core.browser.Browser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
abstract public class AbstractComponentTest {

    @Rule
    public VideoRule videoRule = new VideoRule();
    @Autowired
    protected Browser browser;

    @After
    public void cleanup() {
        browser.quit();
        saveVideoAttachment();
    }

    @Attachment(value = "Video", type = "avi", fileExtension = ".avi")
    public byte[] saveVideoAttachment() {
        try {
            File video = VideoRecorder.getLastRecording();
            await().atMost(10, TimeUnit.SECONDS)
                    .pollDelay(1, TimeUnit.SECONDS)
                    .ignoreExceptions()
                    .until(() -> video != null);
            return Files.readAllBytes(Paths.get(video.getAbsolutePath()));
        } catch (IOException | ConditionTimeoutException e) {
            return new byte[0];
        }
    }
}
