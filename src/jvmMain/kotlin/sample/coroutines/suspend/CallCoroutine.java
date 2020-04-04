package sample.coroutines.suspend;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import sample.coroutines.LogKt;

public class CallCoroutine {
    public static void main(String... args) {
        Object value = SuspendTestKt.hello(new Continuation<Integer>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return EmptyCoroutineContext.INSTANCE;
            }

            @Override
            public void resumeWith(@NotNull Object o) { // ①
                if(o instanceof Integer){
                    handleResult(o);
                } else {
                    Throwable throwable = (Throwable) o;
                    throwable.printStackTrace();
                }
            }
        });

        if(value == IntrinsicsKt.getCOROUTINE_SUSPENDED()){ // ②
            LogKt.log("Suspended.");
        } else {
            handleResult(value);
        }
    }

    public static void handleResult(Object o){
        LogKt.log("The result is " + o);
    }
}