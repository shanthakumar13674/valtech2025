package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.WebSeriesVO;

public interface WebSeriesService {

	WebSeriesVO createorUpdate(WebSeriesVO w);

	List<WebSeriesVO> getAllWebSeries();

	WebSeriesVO getWebSeries(long id);

	List<WebSeriesVO> getAllByEpisodeCount(int count);

	List<WebSeriesVO> getAllByEpisodeDuration(long duration);

}