package com.fmi.web.theaterticketsystem.config;

import com.fmi.web.theaterticketsystem.model.Ticket;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

// annotation for configuration
@ConfigurationProperties(prefix = "config")
@Configuration
public class AppConfig {

    private final LoggerConfig logger = new LoggerConfig();
    private final TicketConfig ticketConfig = new TicketConfig();

    public LoggerConfig getLogger() {
        return logger;
    }

    public TicketConfig getTicket() {
        return ticketConfig;
    }

    @ConfigurationProperties(prefix = "logger")
    @Data
    public class LoggerConfig {
        private String level;

        public String getLevel() {
            return level;
        }
    }

    @ConfigurationProperties(prefix = "ticket")
    @Data
    public class TicketConfig {
        private int rows;
        private int cols;

        public int getRows() {
            return rows;
        }

        public int getCols() {
            return cols;
        }
    }
}
