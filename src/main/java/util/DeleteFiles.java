package util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ログファイル削除用のシングルトンパターンクラス．
 */
public class DeleteFiles {
    
    private static final Logger log = LoggerFactory.getLogger(DeleteFiles.class);
    
	private String[] foldersName;

	/**
	 * クラスコンストラクタ．
	 */
	private DeleteFiles() {
        log.info("delete files...");
		// 削除するフォルダ名
		this.foldersName = new String[] { "log/point", "log/replay" };
	}

	/**
	 * DeleteFilesクラスの唯一のインスタンスを取得する．
	 *
	 * @return DeleteFilesクラスの唯一のインスタンス
	 */
	public static DeleteFiles getInstance() {
		return DeleteFilesHolder.instance;
	}

	/**
	 * getInstance()が呼ばれたときに初めてインスタンスを生成するホルダークラス．
	 */
	private static class DeleteFilesHolder {
		private static final DeleteFiles instance = new DeleteFiles();
	}

	/**
	 * pointフォルダとreplayフォルダ内のファイルを削除する．
	 */
	public void deleteFiles() {
		for (String folderName : foldersName) {
			File[] fileList = (new File(folderName)).listFiles();
			if (fileList != null) {
				for (File file : fileList) {
					if (!file.getName().equals(".gitkeep"))
						file.delete();
				}
			}
		}
        log.info("finish deleting");
	}
}
