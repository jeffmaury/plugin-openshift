/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.ext.openshift.client.config;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.ide.api.action.AbstractPerspectiveAction;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.app.CurrentProject;
import org.eclipse.che.ide.ext.openshift.client.OpenshiftLocalizationConstant;

import javax.validation.constraints.NotNull;
import java.util.Collections;

import static org.eclipse.che.ide.ext.openshift.shared.OpenshiftProjectTypeConstants.OPENSHIFT_PROJECT_TYPE_ID;
import static org.eclipse.che.ide.workspace.perspectives.project.ProjectPerspective.PROJECT_PERSPECTIVE_ID;

/**
 * Action for showing OpenShift application configs with ability
 * to edit them.
 *
 * @author Anna Shumilova
 */
@Singleton
public class ConfigureApplicationAction extends AbstractPerspectiveAction {
    private final AppContext                    appContext;
    private final ConfigureApplicationPresenter presenter;

    @Inject
    public ConfigureApplicationAction(AppContext appContext,
                                      ConfigureApplicationPresenter presenter,
                                      OpenshiftLocalizationConstant locale) {
        super(Collections.singletonList(PROJECT_PERSPECTIVE_ID), locale.applicationConfigAction(), null, null, null);
        this.appContext = appContext;
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        presenter.show();
    }

    @Override
    public void updateInPerspective(@NotNull ActionEvent event) {
        final CurrentProject currentProject = appContext.getCurrentProject();
        event.getPresentation().setVisible(true);
        event.getPresentation().setEnabled(currentProject != null && currentProject.getRootProject().getMixins().contains(OPENSHIFT_PROJECT_TYPE_ID));
    }
}
