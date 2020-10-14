import core.Game;
import manager.DisplayManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * FightingICEのメインメソッドを持つクラス．
 */
public class Main {
    
    private static final Logger log = LoggerFactory.getLogger(Main.class);

	/**
	 * 起動時に入力した引数に応じて起動情報を設定し, それを基にゲームを開始する．<br>
	 * このメソッドはFightingICEのメインメソッドである．
	 *
	 * @param options
	 *            起動時に入力した全ての引数を格納した配列
	 */
	public static void main(String[] options) {
        // remove all java.util.logging's root logger
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        // install slf4j bridge
        SLF4JBridgeHandler.install();
	    log.debug("fightingICE starting...");
		Game game = new Game();
		game.setOptions(options);
		DisplayManager displayManager = new DisplayManager();

		// ゲームの開始
		displayManager.start(game);
	}
}
