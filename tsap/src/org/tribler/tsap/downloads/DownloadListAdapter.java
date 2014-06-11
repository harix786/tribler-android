package org.tribler.tsap.downloads;

import java.util.ArrayList;

import org.tribler.tsap.AbstractArrayListAdapter;
import org.tribler.tsap.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadListAdapter extends AbstractArrayListAdapter<Download> {
	protected int resource;
	protected LayoutInflater inflater;
	
	/**
	 * Constructor: initializes the instance variables
	 * 
	 * @param context
	 *            The context of this adapter
	 * @param resource
	 *            The resource id of the layout
	 */
	public DownloadListAdapter(Context context, int resource) {
		super();
		this.resource = resource;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		Download download = getItem(position);

		if (convertView == null) {
			view = inflater.inflate(resource, parent, false);
		}
		else {
			view = convertView;
		}

		((TextView) view.findViewById(R.id.download_name)).setText(download
				.getName());
		((TextView) view.findViewById(R.id.download_status))
				.setText("Status: " + download.getStatus());
		((TextView) view.findViewById(R.id.download_speed_down))
		.setText("Down: " + download.getDownloadSpeed()/1024 +"Kb");
		((TextView) view.findViewById(R.id.download_speed_up))
		.setText("Up: " + download.getUploadSpeed()/1024 +"Kb");
		((ProgressBar) view.findViewById(R.id.download_progress_bar)).setProgress((int)(download.getProgress()*100));
		return view;
	}
	
	public void replaceAll(ArrayList<Download> newList) {
		content = newList;
		notifyDataSetChanged();
	}
}