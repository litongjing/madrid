package com.future;

import java.util.concurrent.*;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午9:07 2018/2/24
 */
public class RealData implements Callable<String> {
    private String param;

    public RealData(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(param);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        return sb.toString();

    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<String>(new RealData("hello world!"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(futureTask);

        System.out.println("请求完毕。。。");

        for (int i = 0; i < 10; i = i + 1) {
            System.out.println(futureTask.isDone());
            Thread.sleep(200);
        }
        System.out.println("真实数据：" + futureTask.get());
    }
}
