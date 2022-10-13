package editor.tool;

public interface Tool {
	void click(int x, int y);
	void moveTo(int x,int y);
	void release();
}
