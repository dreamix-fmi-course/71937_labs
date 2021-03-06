package com.fmi.web.theaterticketsystem.logger.file;

import com.fmi.web.theaterticketsystem.config.AppConfig;
import com.fmi.web.theaterticketsystem.logger.Logger;
import com.fmi.web.theaterticketsystem.vo.LoggerLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Profile("dev")
@Component
public class LoggerFileImpl implements Logger {
    @Autowired
    AppConfig appConfig;

    @Override
    public void info(Object toLog) {
        this.logInformation(toLog, LoggerLevel.INFO);
    }

    @Override
    public void debug(Object toLog) {
        String level = appConfig.getLogger().getLevel();

        // INFO 1, DEBUG 2 - искаме да логнем всички, които са под
        if (LoggerLevel.valueOf(level).getCode() >= LoggerLevel.DEBUG.getCode()) {
            this.logInformation(toLog, LoggerLevel.DEBUG);
        }
    }

    @Override
    public void trace(Object toLog) {
        // INFO 1, DEBUG 2 - искаме да логнем всички, които са под
        String level = appConfig.getLogger().getLevel();

        if (LoggerLevel.valueOf(level).getCode() >= LoggerLevel.TRACE.getCode()) {
            this.logInformation(toLog, LoggerLevel.TRACE);
        }
    }

    @Override
    public void error(Object toLog) {
        this.logInformation(toLog, LoggerLevel.ERROR);
    }

    private void logInformation(Object toLog, LoggerLevel currentLoggerLevel) {
        File log = new File("log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
            out.println(new Date() + " [" + currentLoggerLevel.getLabel() + "] - " + toLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
