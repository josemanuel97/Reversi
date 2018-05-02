package com.example.pablovilas.reversi;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class CellListener implements OnClickListener {

    private Position position;
    private Context context;
    private Cell cell;
    private Juego juego;

    CellListener(Context context, Position position, Cell cell, Juego juego) {
        this.context = context;
        this.position = position;
        this.cell = cell;
        this.juego = juego;
    }

    @Override
    public void onClick(View v) {
        if(cell.isHint() && juego.state==State.BLACK_TURN){
            juego.move(position);
            if(juego.contador != 0){
                juego.removeArrayFromIndex(juego.board_state.size() - juego.contador - 1);
            }
            juego.updateGrid();
        } else if(juego.state == State.FINISHED) {
            Toast.makeText(context, "Se ha acabado el tiempo", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Invalido", Toast.LENGTH_SHORT).show();
        }
    }
}
