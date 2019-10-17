import React, { Component } from "react";
import { Text, View } from "react-native";

import { IMessage } from "../../types";
import {
    contentStyles,
    otherStyles,
    ownStyles,
    statusStyles,
    styles,
    titleStyles
} from "./styles";

interface IProps extends IMessage {
    onClick?: () => void;
}

class MessageCard extends Component<IProps> {
    public rednderStaus = (contextStyle: any) => {
        const { date } = this.props;

        return (
            <View style={statusStyles.container}>
                <Text style={[statusStyles.text, contextStyle.statusText]}>
                    {date}
                </Text>
            </View>
        );
    };

    public renderContent = (contextStyle: any) => {
        const { text } = this.props;

        return (
            <View style={contentStyles.container}>
                <Text style={[contentStyles.text, contextStyle.text]}>
                    {text}
                </Text>
            </View>
        );
    };

    public renderTitle = () => {
        const { user } = this.props;

        return (
            <View style={titleStyles.container}>
                <Text style={titleStyles.text}>{user.name}</Text>
            </View>
        );
    };

    public renderOwn = () => {
        return (
            <View style={[styles.container, ownStyles.container]}>
                {this.renderContent(ownStyles)}
                {this.rednderStaus(ownStyles)}
                <View style={ownStyles.arrow} />
            </View>
        );
    };

    public renderOther() {
        return (
            <View style={[styles.container, otherStyles.container]}>
                {this.renderTitle()}
                {this.renderContent(otherStyles)}
                {this.rednderStaus(otherStyles)}
                <View style={otherStyles.arrow} />
            </View>
        );
    }

    public render() {
        const { isOwn } = this.props;

        return isOwn ? this.renderOwn() : this.renderOther();
    }
}

export default MessageCard;
