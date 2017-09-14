package com.zen.autumn.learn.guava.concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;

public class ListenableFutureUseCase {

	public static class AsyncFuntionSample implements AsyncFunction<Long, String> {
		private ConcurrentMap<Long, String> map = Maps.newConcurrentMap();
		private ListeningExecutorService listeningExecutorService;

		@Override
		public ListenableFuture<String> apply(final Long input) throws Exception {
			if (map.containsKey(input)) {
				SettableFuture<String> listenableFuture = SettableFuture.create();
				listenableFuture.set(map.get(input));
				return listenableFuture;
			} else {
				return listeningExecutorService.submit(new Callable<String>() {
					@Override
					public String call() throws Exception {
						String retrieved = map.get(input);
						map.putIfAbsent(input, retrieved);
						return retrieved;
					}
				});
			}
		}
	}

	public static class FutureCallbackImpl implements FutureCallback<String> {

		private StringBuilder builder = new StringBuilder();

		@Override
		public void onSuccess(String result) {
			builder.append(result).append(" successfully");
		}

		@Override
		public void onFailure(Throwable t) {
			builder.append(t.toString());
		}

		public String getCallbackResult() {
			return builder.toString();
		}
	}

	static final int NUM_THREADS = 10;

	public static void main(String[] args) {

		ListeningExecutorService executorService = MoreExecutors
				.listeningDecorator(Executors.newFixedThreadPool(NUM_THREADS));

		List<FutureCallbackImpl> futureCallbackList = Lists.newArrayList();
		for (int i = 0; i < NUM_THREADS; i++) {

			final int j = i;
			ListenableFuture<String> listenableFuture = executorService.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					return Thread.currentThread().getName() + " " + j;
				}
			});
			FutureCallbackImpl callback = new FutureCallbackImpl();
			Futures.addCallback(listenableFuture, callback);
			futureCallbackList.add(callback);
		}

		for (FutureCallbackImpl futureCallBack : futureCallbackList) {
			System.err.println(futureCallBack.getCallbackResult());
		}

	}
}
