package com.dtg.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dtg.common.Int2;

public class SpriteMap {
	private String path;
	private int columns;
	private int rows;
	private TextureRegion[][] textureRegions;
	private boolean isDirty = true;
	
	
	public SpriteMap(String path, int rows, int columns) {
		this.path = path;
		this.columns = columns;
		this.rows = rows;
	}
	
	public SpriteMap(String path) {
		this.path = path;
		Texture spriteMapImage = new Texture(Gdx.files.internal(path));
		this.columns = spriteMapImage.getWidth();
		this.rows = spriteMapImage.getHeight();
	}
	
	public int getCellHeight() { return rows; }
	public int getCellWidth() { return columns; }
	public String getPath() { return path; }
	
	public SpriteMap setCellHeight(int cellHeight) { this.rows = cellHeight; isDirty = true; return this; }
	public SpriteMap setCellWidth(int cellWidth) { this.columns = cellWidth; isDirty = true; return this; }
	public SpriteMap setPath(String path) { this.path = path; isDirty = true; return this; }
	
	public TextureRegion[] getFrames(Int2 start, Int2 end) {
		this.buildFrames();
		int spriteFrameCount = (rows * columns) 
				- ((start.y - 1) * columns)
				- (start.x - 1)
				- ((rows - end.y) * columns)
				- (columns - end.x);
		
		assert(end.x < 0);
		
		TextureRegion[] spriteFrames = new TextureRegion[spriteFrameCount];

		int index = 0;
		for (int i = start.y - 1; i <= end.y - 1; i++) {
			int startIndex = ((i == start.y - 1) ? start.x - 1 : 0);
			int endIndex = ((i == end.y - 1) ? end.x : columns);
			for (int j = startIndex; j < endIndex; j++) {
				spriteFrames[index++] = textureRegions[i][j];
			}
		}
		
		return spriteFrames;
	}
	
	
	public TextureRegion getFrame(Int2 coord) {
		this.buildFrames();
		return textureRegions[coord.x - 1][coord.y - 1];
	}
	
	private void buildFrames() {
		if (textureRegions == null || isDirty) {
			Texture spriteMapImage = new Texture(Gdx.files.internal(path));
			textureRegions = TextureRegion.split(
					spriteMapImage,
					spriteMapImage.getWidth() / columns,
					spriteMapImage.getHeight() / rows);
			isDirty = false;
		}
	}
}
