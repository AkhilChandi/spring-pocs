package com.example.controller;

import com.example.entity.SchedulerJobInfo;
import com.example.model.EmailRequest;
import com.example.model.EmailResponse;
import com.example.service.EmailJob;
import com.example.service.SchedulerService;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.UUID;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/emails")
public class EmailSchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @PostMapping("/schedule")
    public ResponseEntity<EmailResponse> scheduleEmail(
        @Valid @RequestBody EmailRequest scheduleEmailRequest) {
        try {
            ZonedDateTime dateTime = ZonedDateTime
                .of(scheduleEmailRequest.getDateTime(), scheduleEmailRequest.getTimeZone());
            if (dateTime.isBefore(ZonedDateTime.now())) {
                EmailResponse scheduleEmailResponse = new EmailResponse(false,
                    "dateTime must be after current time");
                return ResponseEntity.badRequest().body(scheduleEmailResponse);
            }

            SchedulerJobInfo jobDetail = buildJobDetail(scheduleEmailRequest);
            jobDetail.setCronJob(false);
            jobDetail.setRepeatTime(dateTime.getLong(ChronoField.INSTANT_SECONDS));
            schedulerService.scheduleNewJob(jobDetail);

            EmailResponse scheduleEmailResponse = new EmailResponse(true,
                jobDetail.getJobName(), jobDetail.getJobGroup(),
                "Email Scheduled Successfully!");
            return ResponseEntity.ok(scheduleEmailResponse);
        } catch (Exception ex) {
            log.error("Error scheduling email : {}", ex);

            EmailResponse scheduleEmailResponse = new EmailResponse(false,
                "Error scheduling email. Please try later!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(scheduleEmailResponse);
        }
    }

    private SchedulerJobInfo buildJobDetail(EmailRequest scheduleEmailRequest) {

        SchedulerJobInfo schedulerJobInfo = new SchedulerJobInfo();

        JobDataMap jobDataMap = new JobDataMap();

        jobDataMap.put("email", scheduleEmailRequest.getEmail());
        jobDataMap.put("subject", scheduleEmailRequest.getSubject());
        jobDataMap.put("body", scheduleEmailRequest.getBody());

        schedulerJobInfo.setJobDataMap(jobDataMap);
        schedulerJobInfo.setDescription("Send Email Job");
        schedulerJobInfo.setJobGroup("email-jobs");
        schedulerJobInfo.setJobClass(EmailJob.class.getName());
        schedulerJobInfo.setJobName(UUID.randomUUID().toString());

        return schedulerJobInfo;
    }

}