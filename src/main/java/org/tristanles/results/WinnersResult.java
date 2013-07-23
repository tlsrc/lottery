package org.tristanles.results;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.List;

import org.tristanles.Winner;

public class WinnersResult implements LotteryResult {

	private static final String FIRST_HEADER = " 1ère boule ";
	private static final String SECOND_HEADER = " 2ème boule ";
	private static final String THIRD_HEADER = " 3ème boule ";
	private static final String COLUMN = "|";
	
	private Winner first;
	private Winner second;
	private Winner third;
	
	public WinnersResult(Winner first, Winner second, Winner third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public void display() {
		List<StringBuilder> cells = new ArrayList<StringBuilder>(6);
		cells.add(buildTopCell(FIRST_HEADER));
		cells.add(buildTopCell(SECOND_HEADER));
		cells.add(buildTopCell(THIRD_HEADER));
		cells.add(buildBottomCell(first));
		cells.add(buildBottomCell(second));
		cells.add(buildBottomCell(third));

		int maxCellLength = getMaxLength(cells);
		System.out.println(createTable(maxCellLength, cells));
	}

	private StringBuilder buildTopCell(String content) {
		return new StringBuilder(content);
	}

	private StringBuilder buildBottomCell(Winner winner) {
		return new StringBuilder(" ").append(winner.getName()).append(" : ").append(winner.getPrize()).append("$ ");
	}
	
	private int getMaxLength(List<StringBuilder> cells) {
		int currentMax = 0;
		for(StringBuilder sb : cells) {
			currentMax = max(currentMax, sb.length());
		}
		return currentMax;
	}
	
	private String createTable(int maxLength, List<StringBuilder> cells) {
		StringBuilder table = new StringBuilder();
		for (StringBuilder sb : cells) {
			while(sb.length() < maxLength) {
				sb.append(" ");
			}
		}
		
		table.append(cells.get(0)).append(COLUMN).append(cells.get(1)).append(COLUMN).append(cells.get(2));
		table.append(System.lineSeparator());
		table.append(cells.get(3)).append(COLUMN).append(cells.get(4)).append(COLUMN).append(cells.get(5));
		return table.toString();
	}
	
	public Winner getFirst() {
		return first;
	}

	public Winner getSecond() {
		return second;
	}

	public Winner getThird() {
		return third;
	}

}
