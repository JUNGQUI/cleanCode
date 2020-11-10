package com.jklee.cleancode.stringcalculator;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class CustomDelimiter {
	private boolean custom;
	private String delimiter;
}
