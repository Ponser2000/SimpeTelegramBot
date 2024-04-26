package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "<name bot>"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "token bot"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        // TODO: основной функционал бота будем писать здесь
        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT, Map.of("Взять сосиску! +20 славы", "step_2_btn",
                    "Съесть сметану! +20 славы", "step_2_btn",
                    "Сбросить пакет молока! +20 славы", "step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Взлом робота пылесоса!", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT, Map.of("Отправить робот-пылесос за едой! +30 славы", "step_4_btn",
                    "Покататься на роботе-пылесосе! +30 славы", "step_4_btn",
                    "Убежать от робота-пылесоса! +30 славы", "step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Одолеть камеру Go Pro!", "step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT, Map.of("Запилить ролик для Tik-Tok! +40 славы", "step_6_btn",
                    "Выложить фоточки в Инсту! +40 славы", "step_6_btn",
                    "Снять ролик для телеги! +40 славы", "step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Хакнуть комп!", "step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT, Map.of("Выйти во двор и похвастаться!", "step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            sendImageMessageAsync("C:\\Temp\\final_pic.jpg");
            sendTextMessageAsync(FINAL_TEXT);
        }

        if (getMessageText().equals("/glory")) {
            sendTextMessageAsync("Накоплено славы: " + getUserGlory());
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}

 /*       if (getMessageText().contains("бомба")) {
sendTextMessageAsync("Опасность");
        }

                if (getMessageText().contains("Картинка")) {
sendPhotoMessageAsync("step_8_pic");
        }

                if (getMessageText().contains("животное")) {
sendTextMessageAsync("Ваше любимое животное?", Map.of("Кот","cat","Собака","dog"));
        }

        if (getCallbackQueryButtonKey().equals("cat")) {
sendPhotoMessageAsync("step_4_pic");
        }

                if (getCallbackQueryButtonKey().equals("dog")) {
sendPhotoMessageAsync("step_6_pic");
        }

                switch (getMessageText()) {
        case "/start" -> sendTextMessageAsync("Привет");
            case "/bye" -> sendTextMessageAsync("Asta la vista, baby!");
            case "smile" -> editTextMessageAsync(getLastSentMessage().getMessageId(), getLastSentMessage().getText() + " :) ");
        }*/