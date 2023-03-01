// Autogenerated from Pigeon (v9.0.4), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package io.flutter.plugins;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class Pigeon {
  @NonNull
  private static ArrayList<Object> wrapError(@NonNull Throwable exception) {
    ArrayList<Object> errorList = new ArrayList<Object>(3);
    errorList.add(exception.toString());
    errorList.add(exception.getClass().getSimpleName());
    errorList.add(
      "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    return errorList;
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class Chat {
    private @Nullable String message;

    public @Nullable String getMessage() {
      return message;
    }

    public void setMessage(@Nullable String setterArg) {
      this.message = setterArg;
    }

    private @Nullable String clients;

    public @Nullable String getClients() {
      return clients;
    }

    public void setClients(@Nullable String setterArg) {
      this.clients = setterArg;
    }

    public static final class Builder {

      private @Nullable String message;

      public @NonNull Builder setMessage(@Nullable String setterArg) {
        this.message = setterArg;
        return this;
      }

      private @Nullable String clients;

      public @NonNull Builder setClients(@Nullable String setterArg) {
        this.clients = setterArg;
        return this;
      }

      public @NonNull Chat build() {
        Chat pigeonReturn = new Chat();
        pigeonReturn.setMessage(message);
        pigeonReturn.setClients(clients);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<Object>(2);
      toListResult.add(message);
      toListResult.add(clients);
      return toListResult;
    }

    static @NonNull Chat fromList(@NonNull ArrayList<Object> list) {
      Chat pigeonResult = new Chat();
      Object message = list.get(0);
      pigeonResult.setMessage((String) message);
      Object clients = list.get(1);
      pigeonResult.setClients((String) clients);
      return pigeonResult;
    }
  }

  private static class ChatApiCodec extends StandardMessageCodec {
    public static final ChatApiCodec INSTANCE = new ChatApiCodec();

    private ChatApiCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 128:
          return Chat.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof Chat) {
        stream.write(128);
        writeValue(stream, ((Chat) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface ChatApi {

    @NonNull 
    List<Chat> search(@NonNull String keyword);

    /** The codec used by ChatApi. */
    static MessageCodec<Object> getCodec() {
      return ChatApiCodec.INSTANCE;
    }
    /**Sets up an instance of `ChatApi` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, ChatApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.ChatApi.search", getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<Object>();
                try {
                  ArrayList<Object> args = (ArrayList<Object>) message;
                  assert args != null;
                  String keywordArg = (String) args.get(0);
                  if (keywordArg == null) {
                    throw new NullPointerException("keywordArg unexpectedly null.");
                  }
                  List<Chat> output = api.search(keywordArg);
                  wrapped.add(0, output);
                } catch (Error | RuntimeException exception) {
                  ArrayList<Object> wrappedError = wrapError(exception);
                  wrapped = wrappedError;
                }
                reply.reply(wrapped);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
}
