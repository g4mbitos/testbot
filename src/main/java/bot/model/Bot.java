package bot.model;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    private final String token = "916028853:AAHQb0-dSydiucEWjtmci4CrfB0m9qUE3JA";
    private final String name = "test bot";

    public void onUpdateReceived(Update update) {

        Message msg = update.getMessage();
        String txt = msg.getText();

        if(txt.equals("/start")){
            sendMsg(msg, "Hello");
        }

    }

    public String getBotUsername() {
        return name;
    }

    public String getBotToken() {
        return token;
    }

    private void sendMsg(Message msg, String txt){
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setText(txt);
        try {
            execute(s);
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
