package net.punklan.glorfindeil;

/**
 * Created by st020794 on 14.04.2017.
 */
public class Board {
    @Override
    public String toString() {
        return "Board{" +
                "boardName='" + boardName + '\'' +
                ", id=" + id +
                '}';
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    String boardName;
    Long id;

}
